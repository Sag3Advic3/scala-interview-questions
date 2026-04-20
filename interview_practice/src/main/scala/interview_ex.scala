object interview_ex {
    def arrayLength(arr: Array[Int]): Int = {
        var c = 0
        for (i <- arr)
            c += 1
        c
    }

    def mostFrequentwords(phrase: String, k: Int): List[String] = {
        val words = phrase.split(" ")
        val wordCount = scala.collection.mutable.Map[String, Int]()
        for (word <- words) {
            wordCount(word) = wordCount.getOrElse(word, 0) + 1
        }
        println(wordCount)
        val sortedWords = wordCount.toSeq.sortWith(_._2 > _._2).take(k).map(_._1).toList
        sortedWords
    }

    def lastInList(numList: List[Int]): Int = {
        if(numList.length == 1) return numList.head
        else lastInList(numList.tail)
    }
}


//finding most common word(s) in a book most efficiently, k to represent the number of most common words to return
//finding length of an array without using .size or .length

//time complexity of inseration into an array O(n)
//time complexity of looping over the length of an array O(n)
//time complexity of finding an element in an array