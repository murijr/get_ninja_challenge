package br.com.mandy.getninjachallenge.data.repository.offer

import br.com.mandy.getninjachallenge.data.entity.Offers

interface OfferRepository {
    fun getOffers(onSuccess: ((Offers) -> Unit)? = null, onError: ((Throwable) -> Unit)? = null)
}