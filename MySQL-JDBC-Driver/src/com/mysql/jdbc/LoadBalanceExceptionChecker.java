/*
  Copyright (c) 2010, Oracle and/or its affiliates. All rights reserved.

  The MySQL Connector/J is licensed under the terms of the GPL,
  like most MySQL Connectors. There are special exceptions to the
  terms and conditions of the GPL as it is applied to this software,
  see the FLOSS License Exception available on mysql.com.

  This program is free software; you can redistribute it and/or
  modify it under the terms of the GNU General Public License as
  published by the Free Software Foundation; version 2 of the
  License.

  This program is distributed in the hope that it will be useful,  
  but WITHOUT ANY WARRANTY; without even the implied warranty of
  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
  GNU General Public License for more details.

  You should have received a copy of the GNU General Public License
  along with this program; if not, write to the Free Software
  Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
  02110-1301 USA
 
 */

package com.mysql.jdbc;

import java.sql.SQLException;


public interface LoadBalanceExceptionChecker extends Extension {
	
	/**
	 * Invoked to determine whether or a given SQLException should
	 * trigger a failover in a load-balanced deployment.
	 * 
	 * The driver will not pass in a Connection instance when calling init(), but it
	 * will pass in the Properties, otherwise it acts like a normal Extension.
	 * 
	 * One instance of a handler *per* JDBC connection instance will be created. If
	 * you need singleton-like behavior, you're on your own to provide it.

	 * @param ex
	 * @return true if the exception should trigger failover.
	 */
	public boolean shouldExceptionTriggerFailover(SQLException ex);

}
