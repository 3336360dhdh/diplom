package communal.pay.configs


import org.hashids.Hashids
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
open class GlobalConfigs {

  @Bean
  open fun hashids(
      @Value("\${hashids.salt}") salt: String,
      @Value("\${hashids.minLength}") minLength: Int,
      @Value("\${hashids.alphabet}") alphabet: String
  ): Hashids = Hashids(salt, minLength, alphabet)

}
