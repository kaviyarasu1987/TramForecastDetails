package com.rim.tramforecast.data

sealed class Query

object getAntiMeridiem : Query()

object getPostMeridiem : Query()