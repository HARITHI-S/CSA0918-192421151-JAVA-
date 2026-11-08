# Task 5 – Static Members and Object Life Cycle

The ticket counter belongs to the class because all tickets must share one sequence. If it were an instance field, each facility could issue the same number unless a separate shared identifier service were used. With k facility objects, an instance counter uses O(k) counter storage; one static counter uses O(1) counter storage. A central static counter shares numbers across facilities in one JVM. In a multi-process deployment, a database sequence is safer.

After exit processing, an unreferenced ticket can be garbage-collected. Static methods can generate ticket numbers or validate class-wide rules. Objects are passed by value of their reference in Java.
