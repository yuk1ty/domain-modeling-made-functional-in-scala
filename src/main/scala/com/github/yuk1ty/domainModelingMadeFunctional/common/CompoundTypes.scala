package com.github.yuk1ty.domainModelingMadeFunctional.common

case class PersonalName(firstName: String, lastName: String)

case class CustomerInfo(name: PersonalName, emailAddress: EmailAddress)

case class Address(
    addressLine1: String,
    addressLine2: String,
    addressLine3: String,
    addressLine4: String,
    city: String,
    zipCode: ZipCode
)
