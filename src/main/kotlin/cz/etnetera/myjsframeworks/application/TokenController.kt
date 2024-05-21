package cz.etnetera.myjsframeworks.application

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.Authentication
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.oauth2.jwt.JwtClaimsSet
import org.springframework.security.oauth2.jwt.JwtEncoder
import org.springframework.security.oauth2.jwt.JwtEncoderParameters
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import java.time.Instant
import java.util.stream.Collectors


@RestController
class TokenController {
    @Autowired
    private lateinit var encoder: JwtEncoder

    @PostMapping("/token")
    fun token(authentication: Authentication): String {
        // TODO: should be in service
        val now = Instant.now()
        val expiry = 36000L
        val scope: String = authentication.authorities.stream()
            .map { obj: GrantedAuthority -> obj.authority }
            .collect(Collectors.joining(" "))
        val claims = JwtClaimsSet.builder()
            .issuer("self")
            .issuedAt(now)
            .expiresAt(now.plusSeconds(expiry))
            .subject(authentication.name)
            .claim("scope", scope)
            .build()

        return encoder.encode(JwtEncoderParameters.from(claims)).tokenValue
    }
}