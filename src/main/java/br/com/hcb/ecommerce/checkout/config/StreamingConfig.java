package br.com.hcb.ecommerce.checkout.config;

import br.com.hcb.ecommerce.checkout.streaming.CheckoutCreatedSource;
import br.com.hcb.ecommerce.checkout.streaming.PaymentPaidSink;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableBinding(value = {
        CheckoutCreatedSource.class,
        PaymentPaidSink.class
})
public class StreamingConfig {
}
