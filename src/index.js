import SwaggerUI from "swagger-ui";
import SwaggerUIStandalonePreset from "swagger-ui/dist/swagger-ui-standalone-preset";

SwaggerUI({
  dom_id: "body",
  urls: [
    { url: "static/gateway.yml", name: "Trainee Gateway" },
    { url: "static/actions.yml", name: "Actions Service" },
    { url: "static/details.yml", name: "Details Service" },
    { url: "static/forms.yml", name: "Forms Service" },
    { url: "static/notifications.yml", name: "Notifications Service" },
    { url: "static/reference.yml", name: "Reference Service" },
  ],
  presets: [SwaggerUI.presets.apis, SwaggerUIStandalonePreset],
  layout: "StandaloneLayout",
});
