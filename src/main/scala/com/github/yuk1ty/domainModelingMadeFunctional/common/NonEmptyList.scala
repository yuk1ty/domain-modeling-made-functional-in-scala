package com.github.yuk1ty.domainModelingMadeFunctional.common

case class NonEmptyList[+A](head: A, tail: List[A])
    extends Product
    with Serializable
