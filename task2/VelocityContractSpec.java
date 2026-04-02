public class VelocityContractSpec {

    // Class Invariant:
    // speed >= 0
    // 0 <= direction && direction < 360
    // speedX == speed * cos(direction)
    // speedY == speed * sin(direction)

    // Velocity()
    // Pre: true
    // Post:
    // speed == 0
    // direction == 0
    // speedX == 0
    // speedY == 0

    // Velocity(Speed speed, Direction direction)
    // Pre:
    // speed >= 0
    // 0 <= direction && direction < 360
    // Post:
    // this.speed == speed
    // this.direction == direction
    // this.speedX == speed * cos(direction)
    // this.speedY == speed * sin(direction)

    // getSpeed()
    // Pre: true
    // Post: 
    // result == speed
    // speed == old(speed)

    // getSpeedX()
    // Pre: true
    // Post: 
    // result == speedX
    // speedX == old(speedX)

    // getSpeedY()
    // Pre: true
    // Post: 
    // result == speedY
    // speedY == old(speedY)

    // getDirection()
    // Pre: true
    // Post: 
    // result == direction
    // direction == old(direction)

    // setSpeed(Speed speed)
    // Pre: speed >= 0
    // Post:
    // this.speed == speed
    // direction == old(direction)
    // speedX == this.speed * cos(direction)
    // speedY == this.speed * sin(direction)

    // setDirection(Direction direction)
    // Pre: 0 <= direction && direction < 360
    // Post:
    // this.direction == direction
    // speed == old(speed)
    // speedX == speed * cos(this.direction)
    // speedY == speed * sin(this.direction)

    // reverse()
    // Pre: true
    // Post:
    // speed == old(speed)
    // direction == (old(direction) + 180) % 360
    // speedX == -old(speedX)
    // speedY == -old(speedY)

    // reverseX()
    // Pre: true
    // Post:
    // speed == old(speed)
    // speedX == -old(speedX)
    // speedY == old(speedY)
    // direction == (180 - old(direction)) % 360

    // reverseY()
    // Pre: true
    // Post:
    // speed == old(speed)
    // speedX == old(speedX)
    // speedY == -old(speedY)
    // direction == (360 - old(direction)) % 360

}
