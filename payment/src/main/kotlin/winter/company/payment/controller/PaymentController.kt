package winter.company.payment.controller

import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/v1/payment")
class PaymentController {

    @PostMapping("/{id}")
    fun pay(@PathVariable id: Long): Mono<String> {
        return Mono.defer { Mono.just("OK")};
    }
}