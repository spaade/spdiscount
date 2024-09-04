package com.spdiscount.spdiscount.services;

import com.spdiscount.spdiscount.dtos.DiscountOutputDTO;

/**
 * Interface DiscountService
 *
 * Esta interface fornece métodos para gerenciar o desconto de compras.
 *
 * Métodos:
 * - applyDiscount: Aplica um desconto com base no nome do objeto e seu valor.
 */
public interface DiscountService {

    DiscountOutputDTO applyDiscount(String objectName, double value);
}
