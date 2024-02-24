<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:output method="html" omit-xml-declaration="yes"/>
    <xsl:template match="/">
        <div class="links">
            <div align="center">
                <h1>Energies</h1>
            </div>
        </div>
        <div class="customer-input" align="center" valign="middle" style=" margin-left: 50px;">
            <table border="1" style="margin-top: 5px">
                <tr bgcolor="#CCCCCC">
                    <td>
                        <strong>Energy id</strong>
                    </td>
                    <td>
                        <strong>title</strong>
                    </td>
                    <td>
                        <strong>cost</strong>
                    </td>
                    <td>
                        <strong>rate</strong>
                    </td>
                </tr>
                <xsl:for-each select="ArrayList/item">
                    <tr>
                        <td>
                            <xsl:value-of select="id"/>
                        </td>
                        <td>
                            <xsl:value-of select="title"/>
                        </td>
                        <td>
                            <xsl:value-of select="cost"/>
                        </td>
                        <td>
                            <xsl:value-of select="rate"/>
                        </td>
                    </tr>
                </xsl:for-each>
            </table>
        </div>
        <div align="center">
            <p>
                <b>
                    <a href="/api/xsl/game">Game</a>
                </b>
            </p>
        </div>
    </xsl:template>
</xsl:stylesheet>