package com.github.yuk1ty.domainModelingMadeFunctional.common

def createString[Ctor](
    fieldName: String,
    ctor: String => Ctor,
    maxLen: Int,
    str: String
): Either[String, Ctor] = {
  if (str.isEmpty()) {
    Left(s"$fieldName must not be empty")
  } else if (str.length > maxLen) {
    Left(s"$fieldName must not be more than $maxLen chars")
  } else {
    Right(ctor(str))
  }
}

case class String50 private (value: String) extends AnyVal

object String50 {
  def create(fieldName: String, value: String): Either[String, String50] =
    createString(fieldName, String50(_), 50, value)
}

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

case class UnitQuantity private (value: Int) extends AnyVal

object UnitQuantity {
  def create(qty: Int): Either[String, UnitQuantity] = {
    if (qty < 1) {
      Left("UnitQuantity can not be negative")
    } else if (qty > 1000) {
      Left("UnitQuantity can not be more than 1000")
    } else {
      Right(UnitQuantity(qty))
    }
  }
}

case class KilogramQuantity(value: BigDecimal) extends AnyVal

enum OrderQuantity {
  case Unit(quantity: UnitQuantity)
  case Kilogram(quantity: KilogramQuantity)
}

case class CustomerId(value: String) extends AnyVal

case class ShippingAddress(value: String) extends AnyVal

case class BillingAddress(value: BigDecimal) extends AnyVal

case class Price(value: BigDecimal) extends AnyVal

case class Order(
    id: OrderId,
    customerId: CustomerId,
    shippingAddress: ShippingAddress,
    billingAddress: BillingAddress,
    orderLines: NonEmptyList[Order.OrderLine]
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
