/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unrc.app;

/**
 *
 * @author santiago
 */
@BelongsToParents({ 
@BelongsTo(foreignKeyName="player1_id",parent=User.class), 
@BelongsTo(foreignKeyName="player2_id",parent=User.class),
@BelongsTo(foreignKeyName="win_id",parent=User.class) 
}) 
public class Game {
 
}
