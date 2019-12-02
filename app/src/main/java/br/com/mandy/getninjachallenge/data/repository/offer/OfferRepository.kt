package br.com.mandy.getninjachallenge.data.repository.offer

import br.com.mandy.getninjachallenge.data.entity.Offer

interface OfferRepository {
    fun getOffers(onSuccess: (List<Offer>) -> Unit, onError: (Throwable) -> Unit)
}