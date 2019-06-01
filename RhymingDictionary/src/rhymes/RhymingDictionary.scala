package rhymes
import scala.io.{BufferedSource, Source}
import scala.util.control.Breaks._

object RhymingDictionary{
  def findRhymes(filename:String, word2rhyme:String): List[String] = {
    val file: BufferedSource = Source.fromFile(filename)
    var RhymeMap: Map[String,List[String]] = Map()
    var ReturnList: List[String] = List()

    /*var count: Int = 0
    breakable(for(line <- file.getLines()){
      println(line)
      count +=1
      if(count == 100){
        break()
      }
    })*/

    for(line <- file.getLines()) {
      if(line.slice(0,3) != ";;;") {
        //println(line.split(" +").toList)
        RhymeMap += (line.split(" +").head -> line.split(" ").tail.toList)
      }
    }
    //println(RhymeMap)
    val wordcheck: List[String] = RhymeMap("" + word2rhyme)

    for((key, value) <- RhymeMap) {
      if(isRhymeSounds(value,wordcheck) == true) {
        ReturnList = ReturnList :+ key
      }
    }
    //println(RhymeMap)
    return ReturnList
  }

  def isRhymeSounds(arglis1:List[String], arglis2:List[String]): Boolean = {
    val arg1 = arglis1.toArray
    val arg2 = arglis2.toArray

    var lastvowel1 : String = ""
    var lastvowel2 : String = ""

    var count1 = 0
    var count2 = 0

    var check1 : Array[String] = Array()
    var check2 : Array[String] = Array()

    for(i <- arg1){
      if(i.length() == 3) {
        lastvowel1 = i.slice(0,2)
        check1 = arg1.drop(count1 + 1)
      }
      count1 += 1
    }
    for(j <- arg2){
      if(j.length() == 3) {
        lastvowel2 = j.slice(0,2)
        check2 = arg2.drop(count2 + 1)
      }
      count2 += 1
    }
    //println(check1.toList)
    //println(check2.toList)
    //println(lastvowel1)
    //println(lastvowel2)
    if(lastvowel1 == lastvowel2 & check1.toList == check2.toList) {
      true
    } else {
      false
    }
  }

  def getSounds(filename:String, arg2:String): List[String] = {
    val file: BufferedSource = Source.fromFile(filename)
    var RhymeMap: Map[String,List[String]] = Map()
    var soundList: List[String] = List()

    for(line <- file.getLines()) {
      if(line.slice(0,3) != ";;;") {
        RhymeMap += (line.split(" +").head -> line.split(" +").tail.toList)
      }
    }
    //println(RhymeMap)
    if(RhymeMap.isDefinedAt(arg2)) {
      soundList = RhymeMap(arg2)
      //println(soundList)
    }

    return soundList
  }

  def isRhyme(arg1:String, arg2:String, arg3:String): Unit = {

  }

  def main(args: Array[String]): Unit = {
    //val x: Array[String] = Array("TH", "AW1", "Z", "AH0", "N", "D")
    //val y: Array[String] = Array("D", "AY1", "M", "AH0", "N", "D")
    //println(isRhymeSounds(x,y))
    //println(findRhymes("C:\\Users\\woodc\\IdeaProjects\\RhymingDictionaryHW1\\data\\cmudict-0.7b.txt","RAT").length)
    //println(getSounds("C:\\Users\\woodc\\IdeaProjects\\RhymingDictionaryHW1\\data\\cmudict-0.7b.txt","BRAGA"))
  }

}