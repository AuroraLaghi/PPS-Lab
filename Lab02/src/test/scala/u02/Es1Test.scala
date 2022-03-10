package u02

import org.junit.*
import org.junit.Assert.*
import u02.Es1.*

class Es1Test:

  @Test def testParity () =
    assertEquals("odd",parity2(21))
    assertEquals("even",parity2(50))
    assertEquals("odd",parity1(25))
    assertEquals("even",parity1(26))