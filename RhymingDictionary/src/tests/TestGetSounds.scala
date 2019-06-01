package tests

import org.scalatest._
import rhymes.RhymingDictionary._

class TestGetSounds extends FunSuite {

  test("TestGetSounds"){
    val filename: String = "C:\\Users\\woodc\\IdeaProjects\\RhymingDictionaryHW1\\data\\cmudict-0.7b.txt"

    val test_a: String = "AND"
    val test_b: String = "HALF"

    assert(getSounds(filename,test_a) == List("AH0","N","D"))
    assert(getSounds(filename,test_b) == List("HH","AE1","F"))
    assert(getSounds(filename,"HBDFJSDBFSJD") == List())
  }
}