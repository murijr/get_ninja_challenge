package br.com.mandy.getninjachallenge.common.extension

import br.com.mandy.getninjachallenge.data.entity.leaddetail.LeadDetail

val LeadDetail.distanceInkm: Int
    get() = (this.distance ?: 0) / 1000