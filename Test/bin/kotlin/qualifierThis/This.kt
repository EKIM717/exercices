package kotlin.qualifierThis

class A { // implicit label @A
	inner class B { // implicit label @B
		fun Int.foo() { // implicit label @foo
			val a = this@A // A's this
			println(a)
			val b = this@B // B's this
			println(b)
			val c = this // foo()'s receiver, an Int
			println(c)
			val c1 = this@foo // foo()'s receiver, an Int
			println(c1)
			val funLit = lambda@ fun String.() {
				val d = this // funLit's receiver
				println(d)
			}


			val funLit2 = { s: String ->
				// foo()'s receiver, since enclosing lambda expression
				// doesn't have any receiver
				val d1 = this
				println(d1)
			}
		}
	}
}

fun main() {
	val a = A()
	a.B().foo()
}

