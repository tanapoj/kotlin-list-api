fun main(args: Array<String>) {
    demoForEach()
    demoElement()
    demoFirstAndLast()
    demoIndexOf()
    demoSingle()
    demoAggregate()
    demoMap()
    demoFirstAndLast()
    demoFilter()
}

fun demoForEach() {

    val data = listOf(10, 20, 30, 40, 50)
    data.forEach {
        print("$it, ")
    }
    //10, 20, 30, 40, 50,

    println()

    data.forEachIndexed { key, value ->
        print("$key = $value, ")
    }
    //0 = 10, 1 = 20, 2 = 30, 3 = 40, 4 = 50,

    var sum = 0
    data.forEach {
        sum += it
    }
    println("sum = $sum")
    //sum = 150
}

fun demoElement() {

    val data = listOf(10, 20, 30, 40, 50)

    println(data[0])
    //10
    println(data.elementAt(0))
    //10

    try {
        println(data[20])
        println(data.elementAt(20))
    } catch (e: ArrayIndexOutOfBoundsException) {
        e.printStackTrace()
    }

    val defaultValue = 100

    println(data.elementAtOrElse(0) { defaultValue })
    //10 (index 0 exist -> get index 0)
    println(data.elementAtOrElse(20) { defaultValue })
    //100 (index 20 not exist -> calculate from default value)
    println(data.elementAtOrElse(20) { it + defaultValue })
    //120 (index 20 not exist -> calculate from default value and use "it" from refer to index)

    println(data.elementAtOrNull(0))
    //10 (index 0 exist -> get index 0)
    println(data.elementAtOrNull(20))
    //null (index 20 exist -> return null)
}

fun demoFirstAndLast() {

    val data = listOf(10, 20, 30, 40, 50)
    println(data.first())
    //10
    println(data.last())
    //50

    println(data.first { it > 25 })
    //30
    println(data.last { it > 25 })
    //50

    //and for empty list
    val data2 = listOf<Int>()

    println(data2.firstOrNull())
    //null
    println(data2.firstOrNull())
    //null

    try {
        data2.first()
        data2.last()
    } catch (e: NoSuchElementException) {
        e.printStackTrace()
    }
}

fun demoIndexOf() {

    val data = listOf(10, 20, 30, 40, 50)

    println(data.indexOf(10))
    //0
    println(data.indexOf(100))
    //-1

    println(data.indexOfFirst { it > 15 })
    //1
    println(data.indexOfFirst { it > 100 })
    //-1

    println(data.indexOfLast { it > 15 })
    //4
    println(data.indexOfLast { it > 100 })
    //-1
}

fun demoSingle() {

    val data1 = listOf(10)
    println(data1.single())
    //10

    val data2 = listOf(10, 20)
    try {
        println(data2.single())
    } catch (e: IllegalArgumentException) {
        e.printStackTrace()
    }

    println(data2.single { it > 15 });
    //20

    try {
        println(data2.single { it > 5 })
    } catch (e: IllegalArgumentException) {
        e.printStackTrace()
    }
}

fun demoAggregate() {

    val data = listOf(10, 20, 30, 40, 50)

    println(data.any { it > 25 })
    //true
    println(data.any { it > 100 })
    //false

    println(data.all { it > 25 })
    //false
    println(data.all { it > 0 })
    //true

    println(data.none { it > 100 })
    //true
    println(data.none { it > 25 })
    //false

    println(data.count { it > 25 })
    //3
    println(data.count())
    //5
    println(data.size)
    //5

    println(data.contains(10))
    //true
    println(data.contains(100))
    //false
    println(data.containsAll(listOf(10, 20, 30)))
    //true
    println(data.containsAll(listOf(40, 50, 60)))
    //false

    println(data.max())
    //50
    println(data.min())
    //10

    data class Data(var a: Int, var b: Int)

    val data2 = listOf(Data(1, 30), Data(2, 10), Data(3, 20))
    println(data2.maxBy { it.a })
    //Data(a=3,b=20)
    println(data2.minBy { it.b })
    //Data(a=2,b=10)
}

fun demoMap(){

    val data = listOf(10, 20, 30, 40, 50)

    println(data.map{ it + 1 })
    //[11, 21, 31, 41, 51]

    println(data.mapIndexed{ index, value -> index + value})
    //[10, 21, 32, 43, 54]

    println(data.flatMap { listOf(it, it / 10, 100) })
    //[10, 1, 100, 20, 2, 100, 30, 3, 100, 40, 4, 100, 50, 5, 100]

    val data2 = listOf(10, 20, 30, null, 50)
    println(data.mapNotNull{ it })
    //[10, 20, 30, 50]
}

fun demoFilter(){

    val data = listOf(10, 20, 30, 40, 50)
    println(data.filter { it > 25 })
    //[30, 40, 50]
}