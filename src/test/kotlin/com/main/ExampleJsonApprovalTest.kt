package com.main

import org.http4k.core.ContentType.Companion.APPLICATION_JSON
import org.http4k.core.Method.GET
import org.http4k.core.Request
import org.http4k.core.Status.Companion.OK
import org.http4k.core.with
import org.http4k.lens.Header.CONTENT_TYPE
import org.http4k.testing.Approver
import org.http4k.testing.JsonApprovalTest
import org.http4k.testing.assertApproved
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(JsonApprovalTest::class)
class ExampleJsonApprovalTest {

    @Test
    fun `check response content`(approver: Approver) {
        approver.assertApproved(app(Request(GET, "/testing/approval/json")))
    }

    @Test
    fun `check response content with expected status`(approver: Approver) {
        approver.assertApproved(app(Request(GET, "/testing/approval/json")), OK)
    }

    @Test
    fun `check request content`(approver: Approver) {
        approver.assertApproved(
            Request(GET, "/testing/approval/json").with(CONTENT_TYPE of APPLICATION_JSON)
                .body("""{"message":"value"}""")
        )
    }

}
