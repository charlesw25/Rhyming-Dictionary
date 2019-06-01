package tests

import org.scalatest._
import rhymes.RhymingDictionary._

class TestIsRhymeSounds extends FunSuite {

  test("TestRhymeSounds"){
    val w: List[String] = List("TH","AW1","Z","AH0","N","D")
    val x: List[String] = List("D","AY1","M","AH0","N","D")
    val y: List[String] = List("D","AY1","M","AH1","N","D")
    val z: List[String] = List("D","AY1","M","EH0","N","D")

    val a: List[String] = List("D","IH0","F","AY1","N")
    val b: List[String] = List("R","AY1","M")
    val c: List[String] = List("D","AY1","M","AH0","N","E")

    assert(isRhymeSounds(w,x) == true)
    assert(isRhymeSounds(w,y) == true)
    assert(isRhymeSounds(w,z) == false)
    assert(isRhymeSounds(a,b) == false)
    assert(isRhymeSounds(y,z) == false)
    assert(isRhymeSounds(w,c) == false)
  }
}