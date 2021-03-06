package org.goingok.data.models

/**
  * Created by andrew@andrewresearch.net on 30/3/17.
  */

import play.api.libs.json._

case class GoogleUser(gId:String,givenName:String,familyName:String,email:String,emailVerified:Boolean,locale:String)

object GoogleUser {
  implicit val guWrites = new Writes[GoogleUser] {
    def writes(gu: GoogleUser) = Json.obj(
      "gId" -> gu.gId,
      "givenName" -> gu.givenName,
      "familyName" -> gu.familyName,
      "email" -> gu.email,
      "emailVerified" -> gu.emailVerified,
      "locale" -> gu.locale
    )
  }
}
