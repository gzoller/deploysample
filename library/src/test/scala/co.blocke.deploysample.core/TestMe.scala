package co.blocke.deploysample.library

import munit._

class TestMe extends munit.FunSuite:

  test("bye works") {
    val result = SayBye.bye()
    assertEquals(result, "bye!")
  }
