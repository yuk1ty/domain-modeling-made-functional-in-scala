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
