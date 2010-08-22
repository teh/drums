import com.binarycloud.drums.Correlator

val c = new Correlator(4)
val c2 = new Correlator(100)

c.append(0)
c.append(1)
c.append(2)
c.append(3)

println(c.kendall_tau(Array(1.0, 2.0, 3.0)))
println(c.kendall_tau(Array(3.0, 2.0, 1.0)))

println(c.pearson(Array(1.0, 2.0, 3.0)))
println(c.pearson(Array(3.0, 2.0, 1.0)))

val x = Array(0.5720546,0.23154591,-0.040861044,-0.38136974,-0.42223078,-0.50395286,-0.6946377,-1.1849703,-2.2201166,-3.5957718,-5.134871,-5.7886477,-2.7240696,1.920469,9.615966,15.6634)
val dvl = Array(18.959524,19.082108,16.86199,13.211738,9.847511,5.8976107,2.7921712,-0.88532263,-3.173541,-3.568531,-3.568531,-3.0237172,-1.920469,-0.5720546,0.19068487,0.6537767,0.5720546,0.23154591,-0.040861044,-0.38136974,-0.42223078,-0.50395286,-0.6946377,-1.1849703,-2.2201166,-3.5957718,-5.134871,-5.7886477,-2.7240696,1.920469,9.615966,15.6634,17.502148,17.270601,16.698545,14.056199,10.310603,7.8180795,5.7886477,3.568531,0.7627395,-0.5720546,-0.88532263,-0.7627395,-0.50395286,0.10896278,0.50395286,0.7627395,0.7627395,0.95342433,0.84446156,0.6946377,0.42223078,0.3405087,0.23154591,0.14982383,0.10896278,-0.3405087,-1.1441092,-1.7570249,-1.9477097,-1.920469,-1.607201,-0.23154591,2.3426998,9.656827,18.155924,17.502148,15.785983,14.246883,11.34575,8.62168,4.440233,2.2609777,0.6946377,-0.50395286,-0.6537767,-0.19068487,0.95342433,1.7297841,2.2609777,2.3426998,2.1792557,1.7978859,0.92618364,0,-1.2258313,-2.6423476,-4.2904096,-4.8216033,0.10896278,9.956474,18.619015,17.692831,15.636159,12.912089,11.264028,9.193735,6.238119,3.173541,0.50395286,-2.3018389,-3.0645783,-3.3642259,-2.6014864,0.23154591,2.9556155,4.399372,4.140586,2.982856,1.5390993,-0.08172209,-1.2666923,-3.0237172,-5.09401,-6.3607025,-0.9942854,7.7772183,13.211738,17.161638,18.04696,14.941522,11.264028,8.308413,4.903325,1.6889231,-0.7627395,-2.1383946,-2.5606253,-1.9885708,-0.5720546,0.38136974,1.1441092,1.6480621,1.56634,1.334794,0.8036005,-0.08172209,-1.1441092,-3.173541,-5.7477865,-5.7886477,-0.08172209,5.9793324,15.472715,19.504337,18.8097,17.352324,14.410328,10.923519,7.3141265,4.5628166,1.4165162,-0.53119355,-2.1792557,-2.8330324,-2.2609777,-0.46309182,1.1168685,2.4925237,3.336985,3.9499009,3.718355,1.6889231,-0.040861044,-1.920469,-4.0588636,-7.273266,-8.008764,0.6946377,16.930092,19.57244,19.57244,17.393185,13.443283,9.343558,5.284695,0.6537767,-1.6480621,0.7218784,2.9556155,4.8216033,5.09401,3.636633,1.9885708,0.95342433,0.5720546,-0.08172209,-1.1168685,-3.5276701,-6.782933,-7.3141265,-1.1849703,12.258313,19.504337,19.531578,17.311462,13.33432,10.228881,5.2165933,2.070293,-0.9125633,-3.8681788,-4.0180025,-1.9885708,1.7978859,5.175732,5.134871,2.9147544,1.1168685,-0.46309182,-1.6480621,-2.7921712,-3.405087,-4.372132,-5.284695,-4.5628166,-0.23154591,4.372132,17.583868,18.578154,16.167353,12.4489975,9.724928,6.0201936,0.23154591,-1.9477097,-3.173541,-3.7864566,-3.445948,-2.1792557,-0.6537767,0.3405087,1.3075534,1.920469)
val cv = Array(0.0741892775013239,0.0969842999131026,0.0933812710169455,0.0727788332679135,0.0333260694249636,-0.00881656223008981,-0.0505783129510797,-0.0974782639816743,-0.169121985435048,-0.350162488764313,-0.613196609824854,-0.791573544600266,-0.775816391273654,-0.429111762383782,0.304198057367347,0.881466078136608,1,0.9233030307878,0.744724268733321,0.531475737821427,0.300456474450778,0.0640239734065337,-0.124955380472398,-0.252072591178285,-0.334053318932593,-0.400738189443336,-0.431786079024283,-0.419159463549103,-0.367163235354656,-0.274889628962424,-0.165174997693692,-0.0769742457485646,-0.0202209397951973,0.0110400291630161,0.0324564443775355,0.0414774797350402,0.0381205899067975,0.0123443608574966,-0.0283138545038504,-0.100955349644358,-0.229037071660058,-0.244863155388556,-0.375043811859986,-0.649870256742638,-0.787405880284707,-0.74565111545707,-0.603587597226532,-0.399737554612445,0.00843125292375155,0.645867305219743,0.93961486306683,0.970548893643769,0.894659799574713,0.694048132810668,0.447367741355874,0.180432094855538,-0.0505578957057011,-0.267180451895318,-0.408669107193646,-0.467777847096532,-0.468876108363662,-0.414859656991948,-0.326036325919469,-0.210015661464157,-0.094313064412022,-0.00367725751524557,0.0441493702326786,0.0567021051958998,0.0424766666817987,-0.0121725464900382,-0.120665898150072,-0.328384238083338,-0.682419710221593,-0.83151502578876,-0.78027092900499,-0.293084298659263,0.630225038971635,0.955598927223736,0.94777436286255,0.74664548029565,0.454923316179305,0.181448193440773,-0.0254790730315941,-0.187910432940416,-0.315009006982612,-0.404891091944329,-0.467226494520716,-0.466508056577847,-0.417440842677731,-0.326195146589954,-0.164014093326021,0.0318595861642752,0.178023526398356,0.246601971299445,0.219793625513211,0.105758375122974,-0.0739597947405195,-0.267279802756424,-0.480373733776774,-0.65187448856812,-0.688047710493385,-0.342382194540397,0.398801193308633,0.825698209976876,0.934149367714544,0.84879140485506,0.612264580103528,0.306392259561313,0.0215913011238330,-0.211970536838169,-0.373734861612564,-0.457225779992182,-0.469542909858788,-0.426383358219855,-0.342514531271569,-0.227189321123297,-0.109528378337310,-0.00526763895096973,0.0606836556150698,0.0837547235515376,0.0812806419473245,0.0544564291060001,-0.0200483927960922,-0.169088440255607,-0.495882519144687,-0.822442750413574,-0.829591129566634,-0.302905247351228,0.49702721900057,0.919346850121153,0.98116446324702,0.84855860839133,0.623039326980349,0.352710499702332,0.086500528038817,-0.139810354883184,-0.297291439781288,-0.401724273008863,-0.4455363186427,-0.447239380325021,-0.414293847393010,-0.344419388713946,-0.224071689030451,-0.0786258913101617,0.0461958927598707,0.128989254083356,0.184611463927043,0.201626776530349,0.118642021161978,-0.0705253587761089,-0.368024792007131,-0.667291787241856,-0.833450231852931,-0.795443691418677,-0.269692649947975,0.639211107057204,0.92170727130822,0.891189958827095,0.686397402120115,0.3802896196154,0.0744622531642194,-0.179785940094832,-0.373821150922309,-0.460679299373165,-0.393554359385989,-0.247844427679338,-0.09313059871553,0.00640543689722977,0.0160838749242453,-0.0410832063945593,-0.106340718001581,-0.147470504398901,-0.175262485262684,-0.21852895149284,-0.351311469111672,-0.574444584911983,-0.668407625972674,-0.347159554000406,0.519922863142949,0.919061469279412,0.939282065392438,0.752052611362018,0.445259817356468,0.137868808149475,-0.146002644206114,-0.339342586221625,-0.442423845520106,-0.485614357847952,-0.446975520037362,-0.333110649211994,-0.154843978249516,0.047812906691542,0.174973058885154,0.158052881396577,0.0566767373610263,-0.0687662636449252,-0.192915915978912,-0.311786907391235,-0.39385544230703,-0.463246819832025)

for (v <- dvl) {
  c2.append(v)
  println(c2.kendall_tau(x), c2.pearson(x))
}
