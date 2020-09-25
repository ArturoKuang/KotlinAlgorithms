package interview_cake

class WordCloud {
    fun createWordCloud(input: String): Map<String, Int> {
        var wordCloud = mutableMapOf<String, Int>()
        val lowerCaseInput = input.toLowerCase().filter {
            it ->
            when(it) {
                ')' -> false
                '(' -> false
                '"' -> false
                else -> true
            }
        }
        val worldList = lowerCaseInput.split(".", " ", ",", ":", "--")
       for (word in worldList) {
           if(word == "" || word == " ") {
               continue
           }

           wordCloud.merge(word, 1, Int::plus)
       }

        return  wordCloud
    }
}