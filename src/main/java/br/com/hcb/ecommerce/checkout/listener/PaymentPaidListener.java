package br.com.hcb.ecommerce.checkout.listener;

import br.com.hcb.ecommerce.checkout.entity.CheckoutEntity;
import br.com.hcb.ecommerce.checkout.entity.CheckoutEntity.Status;
import br.com.hcb.ecommerce.checkout.event.PaymentCreatedEvent;
import br.com.hcb.ecommerce.checkout.repository.CheckoutRepository;
import br.com.hcb.ecommerce.checkout.streaming.PaymentPaidSink;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentPaidListener {

  private CheckoutRepository checkoutRepository;

  @StreamListener(PaymentPaidSink.INPUT)
  public void handler(PaymentCreatedEvent event){
    CheckoutEntity checkoutEntity = checkoutRepository.findByCode(event.getCheckoutCode())
        .orElseThrow();
    checkoutEntity.setStatus(Status.APPROVED);
    checkoutRepository.save(checkoutEntity);
  }
}
