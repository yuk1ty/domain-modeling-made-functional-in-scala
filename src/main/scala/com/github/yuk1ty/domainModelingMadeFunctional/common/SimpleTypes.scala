package com.github.yuk1ty.domainModelingMadeFunctional.common

case class EmailAddress(value: String) extends AnyVal

enum VipStatus {
  case Normal
  case Vip
}

case class ZipCode(value: String) extends AnyVal

case class UsStateCode(value: String) extends AnyVal

case class OrderId(value: String) extends AnyVal

case class OrderLineId(value: String) extends AnyVal

case class WidgetCode(value: String) extends AnyVal

case class GizmoCode(value: String) extends AnyVal

enum ProductCode {
  case Widget(code: WidgetCode)
  case Gizmo(code: GizmoCode)
}

case class UnitQuantity(value: Int) extends AnyVal

case class KilogramQuantity(value: BigDecimal) extends AnyVal

enum OrderQuantity {
  case Unit(quantity: UnitQuantity)
  case Kilogram(quantity: KilogramQuantity)
}

case class CustomerId(value: String) extends AnyVal

case class CustomerInfo(value: String) extends AnyVal

case class ShippingAddress(value: String) extends AnyVal

case class BillingAddress(value: BigDecimal) extends AnyVal

case class Price(value: BigDecimal) extends AnyVal

case class Order(
    id: OrderId,
    customerId: CustomerId,
    shippingAddress: ShippingAddress,
    billingAddress: BillingAddress,
    orderLines: List[Order.OrderLine]
)

object Order {
  case class OrderLine(
      id: OrderLineId,
      orderId: OrderId,
      productCode: ProductCode,
      orderQuantity: OrderQuantity,
      price: Price
  )
}

enum PlaceOrderError {
  case Validation(
      val validationError: List[PlaceOrderError.ValidationError]
  )
}

object PlaceOrderError {
  case class ValidationError(
      val fieldName: String,
      val errorDescription: String
  )
}
