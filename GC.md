	SerialGC：串行gc
1.	对年轻代使用mark-copy标记-复制算法、对老年代使用mark-sweep-compact标记-清除-整理算法。两者都是单线程。
2.	在GC期间，无论多少CPU内核都只是单线程处理，两个算法都会触发STW。
	ParallelGC：并行GC
1.	在年轻代使用mark-copy标记-复制算法、在老年代使用mark-sweep-compact标记-清除-整理算法。并行处理。
2.	在GC期间，所有CPU内核都在并行处理垃圾。
3.	适用于吞吐量优先的应用。
	CMS GC
1.	对年轻代使用mark-copy标记-复制算法、对老年代使用mark-sweep标记-清除算法。
2.	在mark-sweep阶段能和业务线程一起并发执行。
3.	6个阶段（Initial Mark 初始标记、Concurrent Mark 并发标记、	Concurrent Preclean 并发预清理、Final Remark最终标记、Concurrent Sweep并发清除、Concurrent Reset并发重置）,其中初始标记与最终标记需STW。
4.	老年代不会做压缩处理
5.	适用于延迟低的应用。
	G1 GC
1.	在年轻代、老年代使用mark-compact+copy 标记-整理+复制算法。
2.	全部划分为多个（通常是2048）可以存放对象的小块堆区域。
3.	某些情况下出现Full GC 会退化成SerialGC。
4.	适用于内存堆超过4G 平均GC时间可控的应用。
5.	5阶段（Initial Mark初始标记、Root Region Scan Root区扫描、Concurrent Mark并发标记、Remark再次标记、Cleanup清理），其中再次标记与清理需STW。
	ZGC\ShennandoahGC
1.	试验性GC
2.	适合内存非常大，延迟低的应用。
