package com.amadeus.android.domain.resources

import android.os.Parcelable
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import kotlinx.android.parcel.Parcelize

/**
 * An Airline object as returned by the Airline Code LookUp API.
 * @see com.amadeus.shopping.flightOffersSearch.get
 */
@Parcelize
@JsonClass(generateAdapter = true)
data class FlightOfferSearch(
    val type: String? = null,
    val id: String? = null,
    val source: String? = null,
    val instantTicketingRequired: Boolean = false,
    val nonHomogeneous: Boolean = false,
    val oneWay: Boolean = false,
    val lastTicketingDate: String? = null,
    val numberOfBookableSeats: Int = 0,
    val itineraries: List<Itinerary>? = null,
    var price: SearchPrice? = null,
    val pricingOptions: PricingOptions? = null,
    val validatingAirlineCodes: List<String>? = null,
    val travelerPricings: List<TravelerPricing>? = null
) : Parcelable {

    @Parcelize
    @JsonClass(generateAdapter = true)
    data class Itinerary(
        val duration: String? = null,
        val segments: List<SearchSegment>? = null
    ) : Parcelable

    @Parcelize
    @JsonClass(generateAdapter = true)
    data class SearchSegment(
        val departure: AirportInfo? = null,
        val arrival: AirportInfo? = null,
        val carrierCode: String? = null,
        val number: String? = null,
        val aircraft: Aircraft? = null,
        val duration: String? = null,
        val id: String? = null,
        val numberOfStops: Int = 0,
        val blacklistedInEU: Boolean = false,
        val co2Emissions: List<Co2Emissions>? = null
    ) : Parcelable

    @Parcelize
    @JsonClass(generateAdapter = true)
    data class Co2Emissions(
        val weight: Int = 0,
        val weightUnit: String? = null,
        val cabin: String? = null
    ) : Parcelable

    @Parcelize
    @JsonClass(generateAdapter = true)
    data class AirportInfo(
        val iataCode: String? = null,
        val terminal: String? = null,
        val at: String? = null
    ) : Parcelable

    @Parcelize
    @JsonClass(generateAdapter = true)
    data class Aircraft(
        val code: String? = null
    ) : Parcelable

    @Parcelize
    @JsonClass(generateAdapter = true)
    data class SearchPrice(
        val currency: String? = null,
        val total: Double = 0.0,
        val base: Double = 0.0,
        val fees: List<Fee>? = null,
        var grandTotal: Double? = null,
        val billingCurrency: String? = null,
        val taxes: List<Tax>? = null
    ) : Parcelable

    @Parcelize
    @JsonClass(generateAdapter = true)
    data class Fee(
        val amount: Double = 0.0,
        val type: String? = null
    ) : Parcelable

    @Parcelize
    @JsonClass(generateAdapter = true)
    data class Tax(
        val amount: Double = 0.0,
        val code: String? = null
    ) : Parcelable

    @Parcelize
    @JsonClass(generateAdapter = true)
    data class PricingOptions(
        val includedCheckedBagsOnly: Boolean = false,
        val fareType: List<String>? = null,
        val corporateCodes: List<String>? = null
    ) : Parcelable

    @Parcelize
    @JsonClass(generateAdapter = true)
    data class TravelerPricing(
        val travelerId: String? = null,
        val fareOption: String? = null,
        val travelerType: String? = null,
        val price: SearchPrice? = null,
        val fareDetailsBySegment: List<FareDetailsBySegment>? = null
    ) : Parcelable

    @Parcelize
    @JsonClass(generateAdapter = true)
    data class FareDetailsBySegment(
        val segmentId: String? = null,
        val cabin: String? = null,
        val brandedFare: String? = null,
        val fareBasis: String? = null,
        @Json(name = "class") @field:Json(name = "class") val segmentClass: String? = null,
        val includedCheckedBags: IncludedCheckedBags? = null,
        var additionalServices: FareDetailsAdditionalServices? = null
    ) : Parcelable

    @Parcelize
    @JsonClass(generateAdapter = true)
    data class FareDetailsAdditionalServices(
        var chargeableCheckedBags: ChargeableCheckedBags
    ) : Parcelable

    @Parcelize
    @JsonClass(generateAdapter = true)
    data class ChargeableCheckedBags(
        var quantity: Int = 0
    ) : Parcelable

    @Parcelize
    @JsonClass(generateAdapter = true)
    data class IncludedCheckedBags(
        val weight: Int = 0,
        val weightUnit: String? = null,
        val quantity: Int = 0
    ) : Parcelable
}