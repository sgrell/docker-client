package de.gesellix.docker.client

interface DockerClient {

  def auth(authDetails)

  def build(InputStream buildContext)

  def tag(imageId, repositoryName)

  def push(repositoryName, authBase64Encoded)

  def pull(imageName)

  def ps()

  def images()

  def createContainer(containerConfig)

  def startContainer(containerId)

  def run(fromImage, cmds)

  def stop()

  def rm()

  def rmi()
}
