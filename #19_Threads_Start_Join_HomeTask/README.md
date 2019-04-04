# Working with java threads

Create class Beetle which extend Thread or implement Runnable
in method run() add loops on 10 iterations, between iterations add a Thread.sleep with a random value in the range from 1 to 5 seconds.
After loop will finish set ThreadName in static field WINNER name of thread if WINNER is null.

---

In class for TestBeetle add static String WINNER = null. 
In main create and start 10 Beetle's threads, wait until all threads done and print WINNER name to console
<!--stackedit_data:
eyJoaXN0b3J5IjpbMTMyNTQ4ODE0LC0xNTI4NTA2OTk4LDEwNT
QxMDQ0MzhdfQ==
-->