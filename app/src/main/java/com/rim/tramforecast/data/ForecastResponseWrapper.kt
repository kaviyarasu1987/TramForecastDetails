package com.rim.tramforecast.data

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Element
import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root
import java.util.*



@Root(name = "stopInfo", strict = false)
class ForecastResponseWrapper @JvmOverloads constructor(
    @field:Attribute(name = "created")
    @param:Attribute(name = "created")
    public var created: String?= "",

    @field:Attribute(name = "stop")
    @param:Attribute(name = "stop")
    public var stop: String= "",

    @field:Attribute(name = "stopAbv")
    @param:Attribute(name = "stopAbv")
    public var stopAbv: String?= "",

    @field: Element(name = "message")
    public var message: String?= "",

    @field: ElementList(entry= "direction",inline = true,required = false)
    public var DirectionList: List<DirectionResponse>? = null

)

@Root
class DirectionResponse @JvmOverloads constructor(
    @field:Attribute(name = "name")
    @param:Attribute(name = "name")
    public var name: String= "",
    @field: ElementList(entry="tram",inline = true,required = false)
    public var tramList: List<TramDetails>? = null
)

@Root
 class TramDetails @JvmOverloads constructor(
    @field:Attribute(name = "dueMins")
    @param:Attribute(name = "dueMins")
    public var dueMins: String?= "",

    @field:Attribute(name = "destination")
    @param:Attribute(name = "destination")
    public var destination: String?= ""

)