package kotlin

fun main() {
	var a:List<Int> = listOf(1,2,3,4)
	println(containsOddNum(a))
}

fun isOddNum(i:Int): Boolean=(i % 2 == 0)

fun containsOddNum(collection:Collection<Int>): Boolean=collection.any {it % 2 == 0}