package br.com.hcb.ecommerce.checkout.service;

import br.com.hcb.ecommerce.checkout.entity.CheckoutEntity;
import br.com.hcb.ecommerce.checkout.resource.CheckoutRequest;
import java.util.Optional;

public interface CheckoutService {

    Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest);
}
