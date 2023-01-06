package com.main

import org.http4k.core.Method.GET
import org.http4k.core.Request
import org.http4k.core.Status.Companion.OK
import org.http4k.testing.ApprovalTest
import org.http4k.testing.Approver
import org.http4k.testing.assertApproved
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(ApprovalTest::class)
class ExampleApprovalTest {

    @Test
    fun `check response content`(approver: Approver) {
        approver.assertApproved(app(Request(GET, "/testing/approval/text")))
    }

    @Test
    fun `check response content with expected status`(approver: Approver) {
        approver.assertApproved(app(Request(GET, "/testing/approval/text")), OK)
    }

    @Test
    fun `check request content`(approver: Approver) {
        approver.assertApproved(Request(GET, "/testing/approval/text").body("foobar"))
    }
}
