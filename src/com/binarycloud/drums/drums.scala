package com.binarycloud.drums

import _root_.android.app.Activity
import _root_.android.os.Bundle
import _root_.android.hardware.{SensorManager, SensorEventListener, SensorEvent, Sensor}
import _root_.android.widget.{TextView, Button}
import _root_.android.util.Log
import _root_.android.view.View
import _root_.android.content.Context
import _root_.android.media.{SoundPool, AudioManager}


class Drums extends Activity with SensorEventListener {
  var sm:SensorManager = null
  var output:TextView = null
  val accelerometer_cor = new Correlator(100)
  var backoff = false
  var soundpool = new SoundPool(3, AudioManager.STREAM_MUSIC, 0)
  var plink = 0
  var plink_id = 0

  val template1 = Array(
    -0.6946377,-1.1849703,-2.2201166,-3.5957718,
    -5.134871,-5.7886477,-2.7240696,1.920469,9.615966,15.6634
  )

  override def onCreate(savedInstanceState:Bundle) {
    super.onCreate(savedInstanceState)

    setContentView(R.layout.main)

    sm = getSystemService(Context.SENSOR_SERVICE).asInstanceOf[SensorManager]
    output = findViewById(R.id.output).asInstanceOf[TextView]
    plink = soundpool.load(this, R.raw.plink, 1)
  }

  def onSensorChanged(ev:SensorEvent) {
    val values2 = (for (v <- ev.values) yield "%s  - ".format(v)).foldLeft("")(_+_)
    output.setText("hi %s\n%s\n".format(ev.sensor, values2))
  }

  def onAccuracyChanged(sensot:Sensor, accuracy:Int) {
  }

  val accelor =  new SensorEventListener {
    def onSensorChanged(ev:SensorEvent) {
      accelerometer_cor.append(ev.values(0))
      val cor = accelerometer_cor.kendall_tau(template1);

      if (backoff && cor > 0.4 ) {
	return
      } else {
	backoff = false
      }

      if (cor > 0.80) {
	//soundpool.stop(plink_id)
	backoff = true
	plink_id = soundpool.play(plink, 1.0F, 1.0F, 5, 0, 1.0F)
	Log.d("DRUMS", "play %s, %s".format(cor, plink_id))
      }
      //Log.d("DRUMSSENSOR", "%s, %s, %S".format(ev.values(0), ev.values(1), ev.values(2)))
    }
    def onAccuracyChanged(sensor:Sensor, accuracy:Int) {}
  }

  override def onResume() {
    super.onResume()

    val sl = sm.getSensorList(Sensor.TYPE_ORIENTATION)
    val s2 = sm.getSensorList(Sensor.TYPE_ACCELEROMETER)
    val sensor1 = sl.get(0)
    sm.registerListener(
      this,
      sensor1,
      SensorManager.SENSOR_DELAY_FASTEST
    )
    val sensor2 = s2.get(0)
    sm.registerListener(
      accelor,
      sensor2,
      SensorManager.SENSOR_DELAY_FASTEST
    )
  }
  
  override def onPause() {
    sm.unregisterListener(this)
    sm.unregisterListener(accelor)
    super.onStop()
    if (plink_id > 0) {
      soundpool.stop(plink_id)
    }
  }
}
