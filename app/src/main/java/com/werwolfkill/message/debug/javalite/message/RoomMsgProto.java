// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: RoomMsg.proto

package message;

public final class RoomMsgProto {
  private RoomMsgProto() {}
  public static void registerAllExtensions(
      com.google.protobuf.ExtensionRegistryLite registry) {
  }
  /**
   * Protobuf enum {@code message.SysMsgType}
   */
  public enum SysMsgType
      implements com.google.protobuf.Internal.EnumLite {
    /**
     * <pre>
     *加入游戏
     * </pre>
     *
     * <code>JOIN = 1;</code>
     */
    JOIN(1),
    ;

    /**
     * <pre>
     *加入游戏
     * </pre>
     *
     * <code>JOIN = 1;</code>
     */
    public static final int JOIN_VALUE = 1;


    public final int getNumber() {
      return value;
    }

    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static SysMsgType valueOf(int value) {
      return forNumber(value);
    }

    public static SysMsgType forNumber(int value) {
      switch (value) {
        case 1: return JOIN;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<SysMsgType>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        SysMsgType> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<SysMsgType>() {
            public SysMsgType findValueByNumber(int number) {
              return SysMsgType.forNumber(number);
            }
          };

    private final int value;

    private SysMsgType(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:message.SysMsgType)
  }

  /**
   * Protobuf enum {@code message.GameMsgType}
   */
  public enum GameMsgType
      implements com.google.protobuf.Internal.EnumLite {
    /**
     * <pre>
     *系统
     * </pre>
     *
     * <code>SYSTEM = 1;</code>
     */
    SYSTEM(1),
    /**
     * <pre>
     *玩家
     * </pre>
     *
     * <code>PLAYER = 2;</code>
     */
    PLAYER(2),
    ;

    /**
     * <pre>
     *系统
     * </pre>
     *
     * <code>SYSTEM = 1;</code>
     */
    public static final int SYSTEM_VALUE = 1;
    /**
     * <pre>
     *玩家
     * </pre>
     *
     * <code>PLAYER = 2;</code>
     */
    public static final int PLAYER_VALUE = 2;


    public final int getNumber() {
      return value;
    }

    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static GameMsgType valueOf(int value) {
      return forNumber(value);
    }

    public static GameMsgType forNumber(int value) {
      switch (value) {
        case 1: return SYSTEM;
        case 2: return PLAYER;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<GameMsgType>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        GameMsgType> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<GameMsgType>() {
            public GameMsgType findValueByNumber(int number) {
              return GameMsgType.forNumber(number);
            }
          };

    private final int value;

    private GameMsgType(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:message.GameMsgType)
  }

  /**
   * Protobuf enum {@code message.JoinerStatus}
   */
  public enum JoinerStatus
      implements com.google.protobuf.Internal.EnumLite {
    /**
     * <pre>
     *等待
     * </pre>
     *
     * <code>WAIT = 1;</code>
     */
    WAIT(1),
    /**
     * <pre>
     *准备
     * </pre>
     *
     * <code>READY = 2;</code>
     */
    READY(2),
    /**
     * <pre>
     *存活
     * </pre>
     *
     * <code>LIVE = 3;</code>
     */
    LIVE(3),
    /**
     * <pre>
     *死亡
     * </pre>
     *
     * <code>DEAD = 4;</code>
     */
    DEAD(4),
    ;

    /**
     * <pre>
     *等待
     * </pre>
     *
     * <code>WAIT = 1;</code>
     */
    public static final int WAIT_VALUE = 1;
    /**
     * <pre>
     *准备
     * </pre>
     *
     * <code>READY = 2;</code>
     */
    public static final int READY_VALUE = 2;
    /**
     * <pre>
     *存活
     * </pre>
     *
     * <code>LIVE = 3;</code>
     */
    public static final int LIVE_VALUE = 3;
    /**
     * <pre>
     *死亡
     * </pre>
     *
     * <code>DEAD = 4;</code>
     */
    public static final int DEAD_VALUE = 4;


    public final int getNumber() {
      return value;
    }

    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static JoinerStatus valueOf(int value) {
      return forNumber(value);
    }

    public static JoinerStatus forNumber(int value) {
      switch (value) {
        case 1: return WAIT;
        case 2: return READY;
        case 3: return LIVE;
        case 4: return DEAD;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<JoinerStatus>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        JoinerStatus> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<JoinerStatus>() {
            public JoinerStatus findValueByNumber(int number) {
              return JoinerStatus.forNumber(number);
            }
          };

    private final int value;

    private JoinerStatus(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:message.JoinerStatus)
  }

  /**
   * Protobuf enum {@code message.DeadReason}
   */
  public enum DeadReason
      implements com.google.protobuf.Internal.EnumLite {
    /**
     * <pre>
     *狼杀
     * </pre>
     *
     * <code>KILL = 1;</code>
     */
    KILL(1),
    /**
     * <pre>
     *投票
     * </pre>
     *
     * <code>VOTE = 2;</code>
     */
    VOTE(2),
    /**
     * <pre>
     *毒杀
     * </pre>
     *
     * <code>POISON = 3;</code>
     */
    POISON(3),
    /**
     * <pre>
     *逃跑
     * </pre>
     *
     * <code>AWAY = 4;</code>
     */
    AWAY(4),
    ;

    /**
     * <pre>
     *狼杀
     * </pre>
     *
     * <code>KILL = 1;</code>
     */
    public static final int KILL_VALUE = 1;
    /**
     * <pre>
     *投票
     * </pre>
     *
     * <code>VOTE = 2;</code>
     */
    public static final int VOTE_VALUE = 2;
    /**
     * <pre>
     *毒杀
     * </pre>
     *
     * <code>POISON = 3;</code>
     */
    public static final int POISON_VALUE = 3;
    /**
     * <pre>
     *逃跑
     * </pre>
     *
     * <code>AWAY = 4;</code>
     */
    public static final int AWAY_VALUE = 4;


    public final int getNumber() {
      return value;
    }

    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static DeadReason valueOf(int value) {
      return forNumber(value);
    }

    public static DeadReason forNumber(int value) {
      switch (value) {
        case 1: return KILL;
        case 2: return VOTE;
        case 3: return POISON;
        case 4: return AWAY;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<DeadReason>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        DeadReason> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<DeadReason>() {
            public DeadReason findValueByNumber(int number) {
              return DeadReason.forNumber(number);
            }
          };

    private final int value;

    private DeadReason(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:message.DeadReason)
  }

  /**
   * Protobuf enum {@code message.RoomStatus}
   */
  public enum RoomStatus
      implements com.google.protobuf.Internal.EnumLite {
    /**
     * <pre>
     *空闲
     * </pre>
     *
     * <code>IDLE = 1;</code>
     */
    IDLE(1),
    /**
     * <pre>
     *游戏中
     * </pre>
     *
     * <code>RUNNING = 2;</code>
     */
    RUNNING(2),
    ;

    /**
     * <pre>
     *空闲
     * </pre>
     *
     * <code>IDLE = 1;</code>
     */
    public static final int IDLE_VALUE = 1;
    /**
     * <pre>
     *游戏中
     * </pre>
     *
     * <code>RUNNING = 2;</code>
     */
    public static final int RUNNING_VALUE = 2;


    public final int getNumber() {
      return value;
    }

    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static RoomStatus valueOf(int value) {
      return forNumber(value);
    }

    public static RoomStatus forNumber(int value) {
      switch (value) {
        case 1: return IDLE;
        case 2: return RUNNING;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<RoomStatus>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        RoomStatus> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<RoomStatus>() {
            public RoomStatus findValueByNumber(int number) {
              return RoomStatus.forNumber(number);
            }
          };

    private final int value;

    private RoomStatus(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:message.RoomStatus)
  }

  /**
   * Protobuf enum {@code message.GameRole}
   */
  public enum GameRole
      implements com.google.protobuf.Internal.EnumLite {
    /**
     * <pre>
     *所有角色
     * </pre>
     *
     * <code>ALLROLE = 0;</code>
     */
    ALLROLE(0),
    /**
     * <pre>
     *狼人
     * </pre>
     *
     * <code>WERWOLF = 1;</code>
     */
    WERWOLF(1),
    /**
     * <pre>
     *平民
     * </pre>
     *
     * <code>CIVILIAN = 2;</code>
     */
    CIVILIAN(2),
    /**
     * <pre>
     *女巫
     * </pre>
     *
     * <code>WITCH = 3;</code>
     */
    WITCH(3),
    /**
     * <pre>
     *猎人
     * </pre>
     *
     * <code>HUNTER = 4;</code>
     */
    HUNTER(4),
    /**
     * <pre>
     *预言家
     * </pre>
     *
     * <code>PROPHET = 5;</code>
     */
    PROPHET(5),
    ;

    /**
     * <pre>
     *所有角色
     * </pre>
     *
     * <code>ALLROLE = 0;</code>
     */
    public static final int ALLROLE_VALUE = 0;
    /**
     * <pre>
     *狼人
     * </pre>
     *
     * <code>WERWOLF = 1;</code>
     */
    public static final int WERWOLF_VALUE = 1;
    /**
     * <pre>
     *平民
     * </pre>
     *
     * <code>CIVILIAN = 2;</code>
     */
    public static final int CIVILIAN_VALUE = 2;
    /**
     * <pre>
     *女巫
     * </pre>
     *
     * <code>WITCH = 3;</code>
     */
    public static final int WITCH_VALUE = 3;
    /**
     * <pre>
     *猎人
     * </pre>
     *
     * <code>HUNTER = 4;</code>
     */
    public static final int HUNTER_VALUE = 4;
    /**
     * <pre>
     *预言家
     * </pre>
     *
     * <code>PROPHET = 5;</code>
     */
    public static final int PROPHET_VALUE = 5;


    public final int getNumber() {
      return value;
    }

    /**
     * @deprecated Use {@link #forNumber(int)} instead.
     */
    @java.lang.Deprecated
    public static GameRole valueOf(int value) {
      return forNumber(value);
    }

    public static GameRole forNumber(int value) {
      switch (value) {
        case 0: return ALLROLE;
        case 1: return WERWOLF;
        case 2: return CIVILIAN;
        case 3: return WITCH;
        case 4: return HUNTER;
        case 5: return PROPHET;
        default: return null;
      }
    }

    public static com.google.protobuf.Internal.EnumLiteMap<GameRole>
        internalGetValueMap() {
      return internalValueMap;
    }
    private static final com.google.protobuf.Internal.EnumLiteMap<
        GameRole> internalValueMap =
          new com.google.protobuf.Internal.EnumLiteMap<GameRole>() {
            public GameRole findValueByNumber(int number) {
              return GameRole.forNumber(number);
            }
          };

    private final int value;

    private GameRole(int value) {
      this.value = value;
    }

    // @@protoc_insertion_point(enum_scope:message.GameRole)
  }


  static {
  }

  // @@protoc_insertion_point(outer_class_scope)
}