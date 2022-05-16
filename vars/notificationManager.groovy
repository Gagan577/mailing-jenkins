#!groovy

package workflowlibs.manager;

import groovy.text.StreamingTemplateEngine

/**
 * This method returns a string with the template filled with groovy variables
 */
def emailTemplate(params) {

    def fileName = "email.html.groovy"
    def fileContents = libraryResource(fileName)
    def engine = new StreamingTemplateEngine()

    return engine.createTemplate(fileContents).make(params).toString()
}

/**
 * This method send an email generated with data from Jenkins
 * @param buildStatus String with job result
 * @param emailRecipients Array with emails: emailRecipients = []
 */
def call(String buildStatus,String ver) {

    try {

        def icon = "✅"
        def statusSuccess = true
        def hasArtifacts = true

        if(buildStatus != "SUCCESS") {
            icon = "❌"
            statusSuccess = false
            hasArtifacts = false
        }

        def body = emailTemplate([
            "jenkinsText"   :   ver,
            "jenkinsUrl"    :   env.BUILD_URL,
            "statusSuccess" :   ver,
            "hasArtifacts"  :   hasArtifacts,
            "downloadUrl"   :   "www.downloadurl.com"
        ]);

        mail (to: '97c80a7e7e-d118f8@inbox.mailtrap.io' ,
            subject: "${icon} [ ${env.JOB_NAME} ] [${env.BUILD_NUMBER}] - ${buildStatus}-${env.STAGE_NAME}",
            body: body,
            mimeType: 'text/html'
        );

    } catch (e){
        println "ERROR SENDING EMAIL ${e}"
    }
}
