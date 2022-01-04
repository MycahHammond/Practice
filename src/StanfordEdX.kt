import java.io.File
import java.io.InputStream

fun main() {
//
//    val inputStream : InputStream = File("src/IntegerArray.txt").inputStream()
//    val intList = mutableListOf<Int>()
//
//    inputStream.bufferedReader().forEachLine { intList.add(it.toInt()) }
//
//
//    val p = intList.toTypedArray()
//
//    val b = divideArray(p)
//
//    println("Answer = $b")
}

fun divideArray(array: Array<Int>): Long {
    if (array.size == 1){ return 0}


    var ans: Long= 0

    val l = array.copyOfRange(0, array.size / 2)
    val r = array.copyOfRange(array.size / 2, array.size)

    ans += divideArray(l)
    ans += divideArray(r)

    return ans + mergeDivides(l,r,array)

}

fun mergeDivides(l: Array<Int>, r: Array<Int>, array: Array<Int>): Long {

    var v: Long = 0
    var i = 0
    var j = 0

    for (k in array.indices) {
        if ((j >= r.size) || (i < l.size && l[i] <= r[j])) {
            array[k] = l[i]
            i += 1
        }else{
            array[k] = r[j]
            j += 1
            v += l.size - i
        }
    }

    println(v)
    return v

}
