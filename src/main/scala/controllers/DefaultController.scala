/*
 * Copyright 2016-2017 original author or authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers

import javax.inject.Inject

import org.goingok.BuildInfo
import org.goingok.data.models.{HealthStatus, ServerInfo}
import org.goingok.views.HomePageAngular
import play.api.mvc.{Action, AnyContent, InjectedController}
import play.api.libs.json._

/**
  * Created by andrew@andrewresearch.net on 22/8/17.
  */

class DefaultController @Inject() (assets: AssetsFinder) extends InjectedController {


  def index:Action[AnyContent] = Action {
    Ok(HomePageAngular.render("GoingOK"))
    //Ok(HomePage.render("GoingOK"))
  }

  def health:Action[AnyContent] = Action {
      val healthMessage = HealthStatus(200)
      Ok(Json.toJson(healthMessage))
  }

  def version:Action[AnyContent] = Action {
    Ok(Json.toJson(ServerInfo(BuildInfo.name,BuildInfo.version,BuildInfo.builtAtString)))
  }
}
