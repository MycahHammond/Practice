import kotlin.math.abs

fun main(){

    var a = intArrayOf()
    var b = intArrayOf(4,6,7,1)
    nextPerm(b)
    for (i in b) println(i)
}

fun nextPerm(nums: IntArray): Unit {
    /**
     * find nums[i] < nums[i + 1]
     * swap with next highest
     * reverse tail
     *
     */
    var check = nums.size - 1

    while (check >= 0 && nums[check] > nums[check + 1]){
        check -= 1
    }



}


//#4 Find Median of 2 sorted Arrays
fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double{
    var sorted = IntArray(nums1.size + nums2.size)
    mergeArrs(nums1, nums2, sorted)
    return findMedian(sorted)
}

fun findMedian(arr: IntArray): Double{
    var mid = arr.size / 2
    if (arr.size % 2 != 0){
        return arr[mid].toDouble()
    }else{
        return ((arr[mid] + arr[mid - 1]).toDouble() / 2)
    }
}

fun mergeArrs(l: IntArray, r: IntArray, a: IntArray){
    var li = 0
    var ri = 0

    for(i in a.indices){
        if(ri >= r.size || (li < l.size && l[li] < r[ri])){
            a[i] = l[li]
            li += 1
        }else{
            a[i] = r[ri]
            ri += 1
        }
    }
}//end mergeArrs
//End #4

fun swapPairs(head: ListNode?): ListNode? {
    var dummyHead = ListNode(0)
    var curr = head
    dummyHead.next = curr



    return dummyHead.next
}

fun swapSet(curr: ListNode): ListNode? {
    var tailHead = curr.next?.next
    var n = curr
    var s = curr.next
    s?.next = n
    n.next = tailHead

    return s
}


class ListNode(v: Int, next: ListNode? = null){
    var v = v
    var next = next
}

fun listBuilder(intArray: IntArray): ListNode{
    val temp = ListNode(0)
    var curr = ListNode(0)
    temp.next = curr
    for (i in intArray.indices){
        curr.v = intArray[i]
        if (i + 1 < intArray.size){
            curr.next = ListNode(0)
            curr = curr.next!!
        }
    }

    println(temp.next!!.v)
    return temp.next!!
}

fun addNumbers(l1: ListNode, l2: ListNode): ListNode?{
    var tempRoot = ListNode(0)
    var curr = ListNode(0)
    tempRoot.next = curr

    var carry = 0
    var v1 = 0
    var v2 = 0
    var p1: ListNode? = l1
    var p2: ListNode? = l2

    while (p1 != null || p2 != null){
        if (p1 != null){v1 = p1.v}
        if (p2 != null){v2 = p2.v}
        var sum = carry + v1 + v2
        carry = sum / 10
        curr.v = sum % 10
        curr.next = ListNode(0)
        curr = curr.next!!

        if (p1 != null){p1 = p1.next}
        if (p2 != null){p2 = p2.next}
    }

    if(carry == 1){ curr.next = ListNode(1)}


    println(tempRoot.next?.v)
    return tempRoot.next
}

fun numberOfWays(arr: Array<Int>, k: Int): Int {
    if(arr.size == 0){return 0}
    // Write your code here
    var ans = 0
    val map = mutableMapOf<Int, Int?>()

    for(i in arr.indices){
        val diff = abs(arr[i] - k)
        if(map.containsKey(diff)){
            ans += map[diff] ?: 0
        }
        if(map.containsKey(arr[i])){
            map[arr[i]] = map[arr[i]]?.plus(1)
            println("map ${arr[i]} = ${map[arr[i]]}")
        }else{
            map.put(arr[i], 1)
        }

    }

    return ans
}