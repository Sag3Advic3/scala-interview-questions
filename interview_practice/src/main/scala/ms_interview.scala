import misc.max
object ms_interview {
  val arr = Array(24, 26, 10, 8, 9, 4)

  def findLeaders(arr: Array[Int]): List[Int] = {
    if (arr.isEmpty) return List.empty

    var maxFromRight = arr.last
    var leaders = List(maxFromRight)

    for (i <- arr.length - 2 to 0 by -1) {
      if (arr(i) >= maxFromRight) {
        maxFromRight = arr(i)
        leaders = maxFromRight :: leaders
      }
    }
    leaders
  }

}

//Write an efficient algorythm to find the leaders of an array. A leaders is defined
//by having a value greater than or equal to all the elements on the right-hand side.
// A[24, 26, 9, 8, 10, 2]
//Output: [26, 10, 2]
