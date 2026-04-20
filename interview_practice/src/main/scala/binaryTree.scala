// Scala code for Recursive Binary Search

// Creating object
object BST {

// Creating a recursive  Binary Search function
  def RecursiveBinarySearch(
      arr: Array[Int],
      Element_to_Search: Int
  )(low: Int = 0, high: Int = arr.length - 1): Int = {

    // If element not found
    if (low > high)
      return -1

    // Getting the middle element
    var middle = low + (high - low) / 2

    // If element found
    if (arr(middle) == Element_to_Search)
      return middle

    // Searching in the left half
    else if (arr(middle) > Element_to_Search)
      return RecursiveBinarySearch(arr, Element_to_Search)(low, middle - 1)

    // Searching in the right half
    else
      return RecursiveBinarySearch(arr, Element_to_Search)(middle + 1, high)
  }
}
