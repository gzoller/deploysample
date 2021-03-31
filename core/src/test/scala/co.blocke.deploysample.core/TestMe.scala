package co.blocke.deploysample.core

import munit._

class TestMe extends munit.FunSuite:

  test("it works") {
    val result = SayHello.say()
    assertEquals(result, "hello")
  }
