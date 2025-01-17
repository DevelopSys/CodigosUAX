<?php
/**
 * The base configuration for WordPress
 *
 * The wp-config.php creation script uses this file during the installation.
 * You don't have to use the website, you can copy this file to "wp-config.php"
 * and fill in the values.
 *
 * This file contains the following configurations:
 *
 * * Database settings
 * * Secret keys
 * * Database table prefix
 * * ABSPATH
 *
 * @link https://developer.wordpress.org/advanced-administration/wordpress/wp-config/
 *
 * @package WordPress
 */

// ** Database settings - You can get this info from your web host ** //
/** The name of the database for WordPress */
define( 'DB_NAME', 'wordpress_db' );

/** Database username */
define( 'DB_USER', 'root' );

/** Database password */
define( 'DB_PASSWORD', '' );

/** Database hostname */
define( 'DB_HOST', 'localhost' );

/** Database charset to use in creating database tables. */
define( 'DB_CHARSET', 'utf8mb4' );

/** The database collate type. Don't change this if in doubt. */
define( 'DB_COLLATE', '' );

/**#@+
 * Authentication unique keys and salts.
 *
 * Change these to different unique phrases! You can generate these using
 * the {@link https://api.wordpress.org/secret-key/1.1/salt/ WordPress.org secret-key service}.
 *
 * You can change these at any point in time to invalidate all existing cookies.
 * This will force all users to have to log in again.
 *
 * @since 2.6.0
 */
define( 'AUTH_KEY',         'o^orrS}+xGjOgbgZzS|Is|(/9g8U!5dTJyt!M44FFAi%v][TeOVNrKItznD:&xeU' );
define( 'SECURE_AUTH_KEY',  '1_)$%$+ZQ<=*x;f6tQcUv$N(74k**hZMj4$wA-XRU;z:Vv#5m$yoPyVWWu)xXl%~' );
define( 'LOGGED_IN_KEY',    '9@3>9S#MP;LM]<Fo=S+v89}_}yw@VO3OpHP$DtIn6KvOV%!]q]U&i.}SO8EN{ed%' );
define( 'NONCE_KEY',        '&<F1V4+j#pGz|?z1%afDo.mv@)+:@&>Jz$`)lt}*WM!720+K /yVatQ16`BF wXe' );
define( 'AUTH_SALT',        '{7YTOZ76AQQszu=J8?`Lada$Oa369w?d=nx*lHyruSg{yc=wE[DK<=y>)x$G(evx' );
define( 'SECURE_AUTH_SALT', '*?Z)]ce=-B;G*d;-j{?+u2^?oD=p4?#SInOPU3C_N9NS})[V7_`6fR::|}WOCX>T' );
define( 'LOGGED_IN_SALT',   'Ga=Say(=A#xo9}-+?xQZhPl%]ZMGDK|-X_oqusdzYBZXmeyx]-oe?CzTup:QYogb' );
define( 'NONCE_SALT',       'x/Kr%`J.1/a>>)ltd}:lPPznHlu,Y19P-nQ*4Sfrnjp+PiwA%aZdW<JPPS_ K=k~' );

/**#@-*/

/**
 * WordPress database table prefix.
 *
 * You can have multiple installations in one database if you give each
 * a unique prefix. Only numbers, letters, and underscores please!
 *
 * At the installation time, database tables are created with the specified prefix.
 * Changing this value after WordPress is installed will make your site think
 * it has not been installed.
 *
 * @link https://developer.wordpress.org/advanced-administration/wordpress/wp-config/#table-prefix
 */
$table_prefix = 'wp_';

/**
 * For developers: WordPress debugging mode.
 *
 * Change this to true to enable the display of notices during development.
 * It is strongly recommended that plugin and theme developers use WP_DEBUG
 * in their development environments.
 *
 * For information on other constants that can be used for debugging,
 * visit the documentation.
 *
 * @link https://developer.wordpress.org/advanced-administration/debug/debug-wordpress/
 */
define( 'WP_DEBUG', false );

/* Add any custom values between this line and the "stop editing" line. */



/* That's all, stop editing! Happy publishing. */

/** Absolute path to the WordPress directory. */
if ( ! defined( 'ABSPATH' ) ) {
	define( 'ABSPATH', __DIR__ . '/' );
}

/** Sets up WordPress vars and included files. */
require_once ABSPATH . 'wp-settings.php';