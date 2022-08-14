package winter.company.payment

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class PaymentApplication

fun main(args: Array<String>) {
	runApplication<PaymentApplication>(*args)
}
