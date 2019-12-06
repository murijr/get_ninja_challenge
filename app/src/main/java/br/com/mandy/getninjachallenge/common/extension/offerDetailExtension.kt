package br.com.mandy.getninjachallenge.common.extension

import br.com.mandy.getninjachallenge.data.entity.offerdetail.OfferDetail

val OfferDetail.distanceInkm: Int
    get() = (this.distance ?: 0) / 1000